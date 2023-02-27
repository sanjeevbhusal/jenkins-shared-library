def call() {
    sh """#!/bin/bash
        source venv/bin/activate

        echo \"Running tests....\"
        pytest
    """    
}