def call() {
    sh """#!/bin/bash
        echo \"Creating virutal environment...."
        python -m venv venv

        echo \"Activating virtual environment..."
        source venv/bin/activate

        echo \"Installing all required dependencies...\"
        pip install -r requirements.txt
    """    
}