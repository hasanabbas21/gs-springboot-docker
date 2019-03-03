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
                sh "mvn deploy"
            }
        }
        
        stage ('Deploy to Cloud Foundry - CF PUSH') {
            steps {
                echo 'CF Push '
                sh " curl -O http://localhost:8081/artifactory/libs-snapshot-local/org/springframework/gs-springboot-docker/0.0.15-SNAPSHOT/gs-springboot-docker-0.0.15-20190303.164924-1.jar"
                sh "cp gs-springboot-docker-0.0.15-20190303.164924-1.jar target"
                sleep(20)
                sh "cd target"
                sh "cf login https://api.run.pivotal.io -u mirza.abbas@bcbsma.com -p Winter@2018 -s bcbsma -o 'Northeast / Canada'"
                sh " cf push gs-spring-boot-auto-jenkins-015 -p gs-springboot-docker-0.0.15-20190303.164924-1.jar"
            }
        }
               
    }
}