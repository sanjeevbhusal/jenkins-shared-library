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


}
