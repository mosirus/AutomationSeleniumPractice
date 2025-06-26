pipeline {
    agent any

    environment {
        git_credential = "${params.credential}"
        git_url = "${params.urlProject}"
        tags = "${params.CUCUMBER_TAGS}"
        branches = "${params.branches}"
    }

    tools {
        maven 'Maven 3.8.1'
        jdk 'Java 11'
    }

    stages {
        stage('Clone Project') {
            steps {
                checkout([$class: 'GitSCM',
                    branches: [[name: "${branches}"]],
                    doGenerateSubmoduleConfigurations: false,
                    extensions: [[$class: 'CleanCheckout']],
                    submoduleCfg: [],
                    userRemoteConfigs: [[credentialsId: "${git_credential}", url: "${git_url}"]]
                ])
                sh "ls -ltr"
            }
        }

        stage('Clean Workspace') {
            steps {
                sh 'rm -rf target'
            }
        }

       stage('Build & Test') {
            steps {
                catchError(buildResult: 'UNSTABLE', stageResult: 'FAILURE') {
                    sh "mvn clean test -Dcucumber.filter.tags='${tags}'"
                    }
                }
       }

       stage('Publish Report') {
           steps {
               cucumber buildStatus: 'UNSTABLE',
                    fileIncludePattern: 'target/cucumber-reports/cucumber.json',
                    trendsLimit: 10
           }
       }
    }
}