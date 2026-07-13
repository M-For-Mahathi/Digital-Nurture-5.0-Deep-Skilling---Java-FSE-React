# Module 9 - Microservices with Spring Boot 3 and Spring Cloud

Five independent Maven projects, one folder each. Versions used: Spring Boot **4.0.7**, Spring Cloud **2025.1.2** (the compatible stable pair as of July 2026 — the 4.1.x train is still snapshot-only, so I avoided it).

## Folders
- `eureka-discovery-server` – Eureka registry (port 8761)
- `account` – Account microservice (port 8080)
- `loan` – Loan microservice (port 8081)
- `greet-service` – Greet microservice used with the gateway
- `api-gateway` – Spring Cloud Gateway + logging filter (port 9090)

## How to run each project in VS Code
1. Install the **Extension Pack for Java** and **Spring Boot Extension Pack** in VS Code (Extensions panel, search, Install). This gives you the Spring Boot Dashboard and Maven support.
2. Open each project folder separately in VS Code (`File > Open Folder`), or open the parent `Module 9...` folder — VS Code's Java extension auto-detects multiple Maven projects inside it and lists them in the Spring Boot Dashboard on the left sidebar.
3. To run a service, either:
   - Click the ▶ Run icon next to it in the Spring Boot Dashboard, or
   - Open a terminal in that project's folder and run: `mvn spring-boot:run`
4. To just compile/download dependencies without running: `mvn clean package`

## Part A — Account & Loan registered with Eureka
Run in this order, waiting for each to fully start before starting the next:
1. `eureka-discovery-server` → check http://localhost:8761
2. `account` → check http://localhost:8080/accounts/00987987973432
3. `loan` → check http://localhost:8081/loans/H00987987972342
4. Refresh http://localhost:8761 — you should see `ACCOUNT-SERVICE` and `LOAN-SERVICE` listed under "Instances currently registered with Eureka".

## Part B — API Gateway in front of greet-service
Run in this order:
1. `eureka-discovery-server` → http://localhost:8761
2. `greet-service` → http://localhost:8080/greet (shows "Hello World!!")
3. `api-gateway` → check http://localhost:8761 again, you should now see `API-GATEWAY` and `GREET-SERVICE`
4. Access greet-service through the gateway: http://localhost:9090/greet-service/greet
5. Watch the `api-gateway` console/terminal output — you'll see a log line like `====>Request URL http://localhost:9090/greet-service/greet` printed by `LogFilter`, confirming the global filter is intercepting every request.

Note: `account` and `greet-service` both default to port 8080 — that's fine since they're never run at the same time in these exercises, but if you ever do run them together, change one port in its `application.properties`.

## Pushing this to your existing Git repo
From `F:\Codes\Java\DN DeepSkilling Solutions`:
```
git add .
git commit -m "Add Module 9 - Microservices with Spring Boot and Spring Cloud"
git push
```
(Only relevant if `DN DeepSkilling Solutions` is already a git repo with a remote configured — if not, tell me and I'll walk you through `git init` + adding the remote.)
