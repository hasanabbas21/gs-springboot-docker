pipeline {
    agent any
    tools { 
        maven 'maven' 
        jdk 'java8' 
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                ''' 
            }
        }
        
        stage ('Build') {
            steps {
                echo 'Clean and Build Project'
                sh " mvn clean package"
            }
        }
        
         stage ('Deploy to Artifactory') {
            steps {
                echo 'Deploying jar to artifactory.'
                sh " mvn deploy"
            }
        }
        
        
    }
}