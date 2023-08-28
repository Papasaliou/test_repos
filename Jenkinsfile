pipeline {
    agent any
    tools {
        maven 'Maven'
    }


    stages {
        stage("Source") {
            steps {
                git branch: 'main', url: 'https://github.com/Papasaliou/testsir-booking-app.git'
            }
        }
        stage("Build") {
            steps {
                bat 'mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install'
            }
        }
        stage("SonarQube Analysis") {
            steps {
                bat 'mvn sonar:sonar  '
            }
        }
         stage('Maven version') {
             steps {
                 sh "mvn --version"
            }
         }

        stage('Approve Deployment') {
            input {
                message "Do you want to proceed for deployment?"
            }
            steps {
                bat 'echo "Deploying into Server"'
            }
        }
    }
    post {
        aborted {
            echo "Sending message to agent"
        }
        success {
               emailext(
                   subject: "Build Successful: ${currentBuild.fullDisplayName}",
                   body: "The build was successful. No further action is required.",
                   recipientProviders: [culprits(), developers()],
                   replyTo: "lypapasaliou@gmail.com",
                   to: "lypapasaliou@gmail.com"
               )
           }
           failure {
               emailext(
                   subject: "Build Failed: ${currentBuild.fullDisplayName}",
                   body: "The build has failed. Please investigate and take necessary action.",
                   recipientProviders: [culprits(), developers()],
                   replyTo: "lypapasaliou@gmail.com",
                   to: "lypapasaliou@gmail.com"
               )
           }

    }
}

