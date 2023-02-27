#!usr/bin/env groovy


package com.example

class Docker implements Serializable {

    def script

    Docker(script) {
        this.script = script
    }


    def buildDockerImage(String imageName) {
        script.sh """
            echo \"Building docker image ...\"
            docker build -t $imageName .
        """   
    }


    def loginToDocker() {
        script.withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', usernameVariable: 'USER', passwordVariable: 'PASSWORD')])
        {
            script.sh """
                echo \"Logging into docker hub...\"
                echo $PASSWORD | docker login -u $USER --password-stdin
            """
        }
    }


    def pushDockerImage(String imageName) {
        script.sh """
            echo \"Pushing docker image to docker hub repository...\"
            docker push $imageName
        """    
    }

}
