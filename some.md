https://lang-susanne-muricate.ngrok-free.dev
https://lang-susanne-muricate.ngrok-free.dev/github-webhook/



docker run -d \
--name jenkins \
--user root \
--restart=unless-stopped \
--network selenium-net \
-p 8080:8080 \
-p 50000:50000 \
-v jenkins_home:/var/jenkins_home \
-v /var/run/docker.sock:/var/run/docker.sock \
jenkins-docker