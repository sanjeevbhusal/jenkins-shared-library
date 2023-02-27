def call(String imageName) {
    withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', usernameVariable: 'USER', passwordVariable: 'PASSWORD')])
    {
        sh """
            echo \"Logging into docker hub...\"
            echo $PASSWORD | docker login -u $USER --password-stdin

            echo \"Pushing docker image to docker hub repository...\"
            docker push $imageName
        """
    }
}