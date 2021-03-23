pipeline {
    agent { 
        label 'java'
        }
	
	tools
    {
       maven "maven 3.6.3"
    }
	
     stages {
	 
       stage('checkout') {
           steps {
		    git branch: 'master', credentialsId: 'git_hub', url: 'git@github.com:roolrd/base_of_product.git'
}
       		   
          }
              
       stage('Execute Maven') {
           steps {
             
                sh 'mvn package'             
          }
        }
        
        stage('Docker Build and Tag') {
           steps {
              
               sh 'docker build -t base_of_product .' 
				
               sh 'docker tag base_of_product roolrd/base_of_product:latest'
	       sh 'docker tag base_of_product roolrd/base_of_product:v$BUILD_NUMBER'
				
				// sh  'docker tag base_of_product public.ecr.aws/o9h9g4u8/base-of-product:latest'
				// sh  'docker tag base_of_product public.ecr.aws/o9h9g4u8/base-of-product:v$BUILD_NUMBER'
               
          }
        }
     
         stage('Publish image to Docker Hub') {
            steps {
               withDockerRegistry([ credentialsId: "dockerHub", url: "" ]) {
               sh  'docker push roolrd/base_of_product:latest'
               sh  'docker push roolrd/base_of_product:v$BUILD_NUMBER' 
        }                  
          }
        }
                       
     /*
	 stage('Publish image to ECR') {
      steps {
         sh  'docker push public.ecr.aws/o9h9g4u8/base-of-product:latest'
         sh  'docker push public.ecr.aws/o9h9g4u8/base-of-product:v$BUILD_NUMBER' 
        }                  
          
        }
		*/
		
	     
	     stage('Remove local image') {
             steps {
		     sh 'ls'
               //sh  'docker stop $(docker ps -q) &>/dev/null'
		     
		sh 'docker rmi -f $(docker image ls -q roolrd/base_of_product)'
           }
        }
	 
	     
	 stage('checkout-ansible') {
           
          steps {
		  git branch: 'main', credentialsId: 'git_hub', url: 'git@github.com:roolrd/role-for-updating-web-containers.git'
                 
          }
        }
        
        
        stage('Ansible Deploy') {
             
            steps {
                 sh "ansible-playbook update_n_clean.yml"
                  }

}


}
}
