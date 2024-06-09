#!/bin/bash
#
echo

function initVersion {
  if [[ ! -f "version.json" ]]
then
  cat << EOF > version.json
  {
    "defaultBranch": "master",
    "major": "0",
    "minor": "0"
  }
EOF
fi
}

function isGitRepository {
    [ -d ".git" ]
}


function sanitiseVersion {
    versionStartsWith=$1
    versionNumber=${versionStartsWith#v}
    noSHAVersion=${versionNumber%-*}
    if [[ $noSHAVersion != "$versionNumber" ]]
    then
        noExtraPatch=${noSHAVersion%-*}
        patchNumber=${noExtraPatch##*.}

        patchCount=${noSHAVersion#*-*}
        majorAndMinorVersion=${noSHAVersion%.*}
        major=${majorAndMinorVersion%.*}
        minor=${majorAndMinorVersion#*.}

        if [[ $major -lt $nextMajor ]]
        then
            echo "${nextMajor}.${nextMinor}.0"
        else
            if [[ $minor -lt $nextMinor ]]
            then
                echo "${major}.${nextMinor}.0"
            else
                newPatchVersion=$((patchCount + patchNumber))
                gitVersion="${majorAndMinorVersion}.${newPatchVersion}"
                echo "$gitVersion"
            fi
        fi
    else
        echo "$noSHAVersion"
    fi
}

function currentGitBranch {
  git rev-parse --abbrev-ref HEAD
}

function logFinalVersion {
  is_git_repo=$1
  if [ "$is_git_repo" ]
  then
      echo "1.0.0-SNAPSHOT"
      return 0
  fi

  initVersion
  gitBranch=$(currentGitBranch)
  gitVersion=$(git describe --always)
  nextMajor=$(grep "major" version.json | cut -d\" -f4)
  nextMinor=$(grep "minor" version.json | cut -d\" -f4)
  defaultBranch=$(grep "defaultBranch" version.json | cut -d\" -f4)
  finalVersion=$(buildCurrentReleaseVersion "$gitBranch" "$gitVersion" "$nextMajor" "$nextMinor" "$defaultBranch")
  echo "${finalVersion}"
}

function buildCurrentReleaseVersion {
  gitBranch=$1
  gitVersion=$2
  nextMajor=$3
  nextMinor=$4
  defaultBranch=$5

  if [[ ! "${gitVersion}" =~ ^v?.+\..+\.[^-]+ ]]
  then
    gitVersion="${nextMajor}.${nextMinor}.1"
  fi
  finalVersion=$gitVersion
  if [[ $gitBranch == "$defaultBranch" ]]
  then
      finalVersion=$(sanitiseVersion "$gitVersion")
  else
      finalVersion="${gitVersion}-${gitBranch}"
      finalVersion=${finalVersion#v}
  fi

  echo "$finalVersion" | tr -d '[:space:]'
}

logFinalVersion "$(isGitRepository)"

