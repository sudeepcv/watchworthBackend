# Watchworth Backend

This repository contains the backend for the Watchworth application. The backend is built using Java and Spring Boot, with a simple H2 database for local development. It is containerized using Docker and deployed to Kubernetes.

## Prerequisites

- Docker
- Kubernetes (e.g., Docker Desktop with Kubernetes enabled)
- kubectl CLI

## Local Development

### Building the Docker Image

To build the Docker image locally, run the following command:

    docker build -t cvsudeep/watchworthbackend .


### To run the backend in a Docker container with environment variables:

 ```bash 
 
 docker run  \
  --name watchworthbackend \
  -e DATASOURCE_URL=jdbc:h2:~/watchworth \
  -e DATASOURCE_USERNAME=sa \
  -e DATASOURCE_PASSWORD= \
  -p 8080:8080 \
  cvsudeep/watchworthbackend

```


  ### Kubernetes Deployment

Preparing Your Environment

To access the backend using a custom domain, you need to map backend.watchworth.com to localhost. Edit your /etc/hosts file:

```bash 
sudo nano /etc/hosts
```
Add the following entry:

```bash 
127.0.0.1 backend.watchworth.com
```
### Kubernetes Deployment Files
The Kubernetes manifests for deploying the backend are located in the k8s folder. These include:

backend-configmap.yaml: ConfigMap for application configuration.

backend-deployment.yaml: Deployment configuration for the backend service.
backend-ingress.yaml: Ingress configuration for routing traffic.
backend-secret.yaml: Secret configuration for sensitive data.
backend-service.yaml: Service configuration for exposing the backend.
Deploying to Kubernetes
To deploy the backend to Kubernetes, run the following commands in the k8s folder:

```bash
kubectl apply -f backend-configmap.yaml
kubectl apply -f backend-secret.yaml
kubectl apply -f backend-service.yaml
kubectl apply -f backend-deployment.yaml
kubectl apply -f backend-ingress.yaml
```
Accessing the Backend
Once deployed, the backend will be accessible at:


http://backend.watchworth.com
you need to install ingress-nginx
```bash
helm upgrade --install ingress-nginx ingress-nginx \
  --repo https://kubernetes.github.io/ingress-nginx \
  --namespace ingress-nginx --create-namespace
```

hosted on redhat openshift k8s:

https://watchworth-backend-sudeepcv007-dev.apps.sandbox-m3.1530.p1.openshiftapps.com/
