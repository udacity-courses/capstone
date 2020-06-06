dockerpath="anyulled/capstone"

kubectl run capstone\
    --generator=run-pod/v1\
    --image=$dockerpath\
    --port=80 --labels app=capstone

kubectl get pods

kubectl port-forward capstone 8000:80