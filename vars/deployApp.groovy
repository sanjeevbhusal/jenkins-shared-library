def call(String imageName) {
    def dockerCommand = "docker run -p 5000:5000 -d $imageName"
    sshagent(['jenkins-server-ec2-instance']) {
        echo "Deploying Application on the host..."
        sh "ssh -o StrictHostKeyChecking=no ec2-user@13.127.170.21 $dockerCommand"
    }
}