# SYSTEM DESIGN

## Database

### HTTP API
```http
GET /users/12 – Retrieve user object for id = 12
{
    "id": 12
}
```

## Web Tier, Data Tier

### Load Balancer
- Evenly distributes traffic among web servers that are defined in a load-balanced set.

### Databases
#### Relational Databases (RDBMS or SQL)
- MySQL, Oracle Database, PostgreSQL, etc.

#### Non-Relational Databases (NoSQL)
- CouchDB, Neo4j, Cassandra, HBase, Amazon DynamoDB, etc.
- Four categories:
  - Key-Value Stores
  - Graph Stores
  - Column Stores
  - Document Stores

### When to Use NoSQL
- Your application requires super-low latency.
- Your data are unstructured, or you do not have any relational data.
- You only need to serialize and deserialize data (JSON, XML, YAML, etc.).
- You need to store a massive amount of data.

## Scaling Strategies

### Vertical Scaling vs Horizontal Scaling
- **Vertical Scaling**: Upgrading hardware resources (CPU, RAM, storage).
- **Horizontal Scaling**: Adding more servers to distribute load.

### Problems with a Single Web Server
- If the web server goes offline, users cannot access the website.
- High user load can cause slower response times or failures.
- A **load balancer** mitigates these issues by distributing traffic across multiple servers.

### Database Replication
- Ensures failover and redundancy.
- Uses **Master-Slave Replication**:
  - **Master**: Handles write operations.
  - **Slaves**: Handle read operations.
- **Advantages**:
  - Better Performance
  - Reliability
  - High Availability

## Improving Load/Response Time

### Cache Layer
- Stores frequently accessed data in memory for faster retrieval.
- **Cache Tier**: A separate layer dedicated to caching, reducing database workloads and improving performance.

#### Considerations for Using Cache
- When to use cache (frequent/infrequent data access).
- Expiration policies.
- Ensuring consistency and mitigating failures.

#### Eviction Policies
- **LRU (Least Recently Used)**
- **LFU (Least Frequently Used)**
- **FIFO (First In, First Out)**

### Content Delivery Network (CDN)
- Distributes static content (images, videos, JavaScript, CSS) across multiple geographically dispersed servers.
- Uses **Time-to-Live (TTL)** to manage cache expiration.

#### Considerations for Using a CDN
- Cost (third-party providers).
- Cache expiry settings.
- CDN fallback and file invalidation.

## Stateless Web Tier
- Storing session data in persistent storage (SQL/NoSQL) enables **stateless architecture**.
- HTTP requests can be handled by any web server without maintaining session data on the server itself.

### Stateful vs Stateless Architecture
- **Stateful**: Server remembers client data between requests.
- **Stateless**: No state is stored on the server; all session data is stored externally.

### Auto Scaling
- Adds/removes web servers based on traffic load.

## Multi-Data Center Support
- **GeoDNS**: Resolves domain names based on the user’s location to improve availability and performance.

## Decoupling System Components

### Message Queue
- Enables **asynchronous communication** by acting as a buffer between producer and consumer services.
- **Producers** publish messages to the queue, and **consumers** process them asynchronously.
- Used in **photo customization tasks** (blurring, sharpening, etc.).

## System Monitoring and Automation

### Logging
- Identifies errors and system issues.

### Metrics Collection
- Provides business insights and monitors system health.

### Automation
- Improves productivity in large and complex systems.
- **Continuous Integration (CI)** is a recommended practice.

## Database Scaling

### Amazon RDS
- Supports up to **24 TB of RAM**.
- Example: StackOverflow (2013) had **10 million+ monthly unique visitors** but only one master database.

### Challenges of Vertical Scaling
- Hardware limits (CPU, RAM, storage).
- Single point of failure (SPOF).
- High cost (powerful servers are expensive).

### Horizontal Scaling (Sharding)
- Divides a database into smaller, more manageable **shards**.
- Each shard has a **unique subset of data but shares the same schema**.

#### Considerations for Sharding
- **Sharding Key** (Partition Key) determines data distribution.
- **Resharding**: Adjusting shard distribution as data grows.
- **Celebrity Problem**: Uneven distribution of high-traffic data.
- **Join and De-normalization**: Joins across shards can be complex.

### Hybrid Approach
- Some non-relational functionalities are offloaded to **NoSQL databases** to reduce database load.