# System Design

## Database

### HTTP API
```http
GET /users/12 – Retrieve user object for id = 12
{
    "id": 12
}
```

### Web Tier, Data Tier

### Load Balancer
A load balancer evenly distributes traffic among web servers that are defined in the load-balanced set.

### RDBMS or SQL Database
- MySQL, Oracle Database, PostgreSQL, etc.

### NoSQL Databases
- CouchDB, Neo4j, Cassandra, HBase, Amazon DynamoDB, etc.
- These contain four categories:
  - **Key-value stores**
  - **Graph stores**
  - **Column stores**
  - **Document stores**

### When to Choose NoSQL
- Your application requires super-low latency.
- Your data are unstructured, or you do not have any relational data.
- You only need to serialize and deserialize data (JSON, XML, YAML, etc.).
- You need to store a massive amount of data.

## Vertical Scaling vs Horizontal Scaling

In the previous design, users are connected to the web server directly. If the web server goes offline, users will be unable to access the website. If many users access the web server simultaneously and it reaches the server’s load limit, users experience slower response times or failures to connect.

### Load Balancer
A load balancer evenly distributes incoming traffic among web servers that are defined in a load-balanced set.

## Data Tier Improvements
The current design has one database, so it does not support failover and redundancy. **Database replication** is a common technique to address these problems.

### Database Replication
Database replication is used in many database management systems, usually with a master/slave relationship:
- **Master** (only write operations)
- **Slaves** (only read operations)

**Advantages:**
- Better performance
- Reliability
- High availability

## Enhancing Load/Response Time
### Cache Layer & CDN
- **Cache**: A temporary storage area that stores expensive responses or frequently accessed data in memory.
- **Cache Tier**: A separate cache tier improves system performance, reduces database workloads, and scales independently.

### Considerations for Using Cache
- When to use cache (avoid for infrequent data access)
- Expiration policy
- Consistency
- Mitigating failures (Single Point of Failure (SPOF) - multiple caches in multiple data centers)

### Eviction Policies
- **LRU** (Least Recently Used)
- **LFU** (Least Frequently Used)
- **FIFO** (First In, First Out)

### Content Delivery Network (CDN)
A CDN is a network of geographically dispersed servers used to deliver static content (images, videos, CSS, JavaScript, etc.). The nearest CDN server to the user serves the static content.

### Considerations for Using a CDN
- Cost (third-party providers)
- Setting an appropriate cache expiry
- CDN fallback
- Invalidating files

## Stateless Web Tier
To scale the web tier horizontally, session data is stored in persistent storage (SQL/NoSQL). Each web server can access state data from the database.

### Stateful vs Stateless Architecture
- **Stateful Server**: Remembers client data from one request to the next.
- **Stateless Server**: Keeps no state information.

### NoSQL for Stateless Architecture
NoSQL data stores are chosen as they are easy to scale. **Autoscaling** adds/removes web servers based on traffic load.

## Multi-Data Center Support
### GeoDNS
GeoDNS resolves domain names to IP addresses based on a user’s location to improve availability and user experience.

## Decoupling Components with Messaging Queues
### Message Queue
A **message queue** is a durable component stored in memory that supports asynchronous communication.

**Architecture:**
- **Producers/Publishers** create and publish messages.
- **Consumers/Subscribers** retrieve messages from the queue.

### Benefits of Message Queue
- Decoupling components for scalability and reliability.
- The producer can post messages even if the consumer is unavailable.
- The consumer can process messages even if the producer is offline.

#### Example Use Case
- **Photo Customization Jobs** (blur, sharpen, etc.)

## Logging & Monitoring
- **Error Logs**: Identify system issues.
- **Metrics**: Provide business insights and system health monitoring.
- **Automation**: As systems scale, automation tools enhance productivity (e.g., Continuous Integration).

## Scaling the Database
### Vertical vs Horizontal Scaling
- **Amazon RDS** supports up to 24 TB of RAM.
- **Example**: StackOverflow.com (2013) handled 10M+ monthly users with one master database.

### Challenges of Vertical Scaling
- Hardware limits (CPU, RAM, etc.)
- Single point of failure risk
- High cost (powerful servers are expensive)

### Horizontal Scaling (Sharding)
Sharding splits large databases into smaller, manageable parts called **shards**. Each shard has the same schema but contains unique data.

### Considerations for Sharding
- **Sharding Key** (Partition Key): Determines how data is distributed.

### Challenges of Sharding
- **Resharding Data**
- **Celebrity Problem**
- **Joins & Denormalization**

To support increasing traffic, some non-relational functionalities are offloaded to a NoSQL data store to reduce database load.
