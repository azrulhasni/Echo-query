Echo Query Service
==================

 

By Azrul MADISA

April 2020

 

What is this and what does it do?
---------------------------------

This is a Spring Boot service that returns the query and header pass by the
caller back as a JSON String

 

Request:

<http://localhost:13600/echo/query?hello=123&world=456>

Respond:

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
{
   "query":{
      "hello":"123",
      "world":"456"
    },
   "header":{
      "host":"localhost:13600",
      "connection":"keep-alive",
      "dnt":"1",
      "upgrade-insecure-requests":"1",
      "user-agent":"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.163 Safari/537.36",
      "sec-fetch-dest":"document",
      "accept":"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
      "sec-fetch-site":"none",
      "sec-fetch-mode":"navigate",
      "sec-fetch-user":"?1",
      "accept-encoding":"gzip, deflate, br",
      "accept-language":"en-US,en;q=0.9,ms;q=0.8,fr;q=0.7",
      "cookie":"XSRF-TOKEN=8bc9ddba-ef6e-4917-93b4-bca91a36c932"
    }
}
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

 

Installation
------------

-   Make sure you have a running Kubernetes cluster

-   Run:

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
> kubectl run --image=azrulhasni/echoquery:latest echoquery-app --port=13600
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-   Expose as a LoadBalancer service

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
> kubectl expose deployment echoquery-app --type=LoadBalancer --name=echoquery-http
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-   Check if the service is OK

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
> kubectl get svc
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

The result should show:

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
NAME              TYPE           CLUSTER-IP      EXTERNAL-IP   PORT(S)                         AGE
echoquery-http    LoadBalancer   10.104.56.221   localhost     13600:32140/TCP                12s      5h50m
kubernetes        ClusterIP      10.96.0.1       <none>        443/TCP                         17h
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

 

Building
--------

-   Download the source code
