def call(String imageName) {
    sh """
        echo \"Building docker image ...\"
        docker build -t $imageName .
    """    
}