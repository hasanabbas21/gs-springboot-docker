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
        
         stage ('Test') {
            steps {
                echo 'Run Junit Tests'
                sh " mvn test"
            }
        }
        
         stage ('Deploy to Artifactory') {
            steps {
                echo 'Deploying jar to artifactory.'
                sh "release:clean release:prepare release:perform"
                sleep(20)
            }
        }
        
         stage ('Run Application - jar') {
            steps {
                echo 'Running the jar file '
                sh " curl -O http://localhost:8081/artifactory/libs-release-local/org/springframework/gs-springboot-docker/0.0.14-SNAPSHOT/gs-springboot-docker-0.0.14-SNAPSHOT.jar"
                sh "cp gs-springboot-docker-0.0.14-SNAPSHOT.jar target"
                sleep(20)
                sh "cd target"
                sh " java -jar gs-springboot-docker-0.0.14-SNAPSHOT.jar"
            }
        }

               
    }
}