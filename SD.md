# System Design

## Quick Notes


- Design clear & secure APIs
- Use auto scaling for traffic spikes
- Index databases to optimize reads
- Assume failures. Make it fault-tolerant
- Partition and shard data for large datasets
- Shard SQL databases for horizontal scaling
- Use CDNs to reduce latency for global users
- Use websockets for real-time communication
- Use write-through cache for write-heavy apps
- Use an API gateway for multiple microservices
- Use microservices over monoliths for scalability
- Denormalize databases for read-heavy workloads
- Use SQL for structured data and ACID transactions
- Use load balancers for traffic distribution and availability
- Implement data replication and redundancy for fault tolerance
- Clarify functional and non-functional requirements before designing
- Add functionality only when needed. Avoid over-engineering
- Use rate limiting to prevent overload and DOS attacks
- Use heartbeats/health checks for failure detection
- Use the circuit breaker pattern to prevent failures
- Use message queues for async communication
- Make operations idempotent to simplify retries
- Use read-through cache for read-heavy apps
- Use event-driven architecture for decoupling
- Use async processing for non-urgent tasks
- Use data lakes or warehouses for analytics
- Prefer horizontal scaling for scalability
- No perfect solution—only trade-offs
- Use NoSQL for unstructured data
- Use blob storage for media files

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

## To support increasing traffic
Some non-relational functionalities are offloaded to a NoSQL data store to reduce database load.

## Millions of users and beyond
We provide a summary of how we scale our system to support millions of users:
- Keep web tier stateless
- Build redundancy at every tier
- Cache data as much as you can
- Support multiple data centers
- Host static assets in CDN
- Scale your data tier by sharding
- Split tiers into individual services
- Monitor your system and use automation tools

## BACK-OF-THE-ENVELOPE ESTIMATION
A byte is a sequence of 8 bits. An ASCII character uses one byte of memory (8 bits).

### Table explaining the data volume unit power of 2:
| Power | Value | Description |
|--------|--------|------------------|
| 2^10 | 1 thousand | 1 KB, A thousand is a number with 3 zeros |
| 2^20 | 1 million | 1 MB, A million is a number with 6 zeros |
| 2^30 | 1 billion | 1 GB, A billion is a number with 9 zeros |
| 2^40 | 1 trillion | 1 TB, A trillion is a number with 12 zeros. |
| 2^50 | 1 quadrillion | 1 PB, A quadrillion is a number with 15 zeros. |

## Latency numbers:
- L1 cache - 0.5 ns
- L2 cache reference - 7 ns
- Main memory reference - 100 ns
- Compress 1 KB with zippy - 10 microsec
- Read 1 MB sequentially from main memory - 250 microsec
- Disk seek - 10 ms
- Read 1 MB sequentially from the network - 10 ms
- Read 1 MB sequentially from disk - 30 ms
- Send packet from Netherlands to CA - RTT - 150 ms

### Time Conversions:
- ns = nanosecond, μs = microsecond, ms = millisecond
- 1 ns = 10^-9 seconds
- 1 μs = 10^-6 seconds = 1,000 ns
- 1 ms = 10^-3 seconds = 1,000 μs = 1,000,000 ns

### Observations:
- Memory is fast but the disk is slow.
- Avoid disk seeks if possible.
- Simple compression algorithms are fast.
- Compress data before sending it over the internet if possible.
- Data centers are usually in different regions, and it takes time to send data between them.

## Availability numbers
High availability is the ability of a system to be continuously operational for a desirably long period of time. High availability is measured as a percentage, with 100% meaning a service that has 0 downtime. Most services fall between 99% and 100%.

| Availability % | Downtime per day | Downtime per year |
|---------------|----------------|----------------|
| 99% | 14.40 minutes | 3.65 days |
| 99.9% | 1.44 minutes | 8.77 hours |
| 99.99% | 8.64 seconds | 52.60 minutes |
| 99.999% | 864 milliseconds | 5.260 minutes |
| 99.9999% | 86.4 milliseconds | 31.56 seconds |

## Example - Twitter QPS and storage requirements
### Assumptions:
- 300 million monthly active users
- 50% of users use Twitter daily
- Users post 2 tweets per day on average
- 10% of tweets contain media
- Data is stored for 5 years.

### Estimations:
#### Daily Active Users (DAU):
```
DAU = 300 million * 50% = 150 million
```

#### Tweets QPS:
```
Tweets QPS = (150 million * 2 tweets) / (24 * 3600 seconds)
           = 300 million / 86400
           = 3500 tweets QPS (approx.)
```
#### Peak QPS:
```
Peak QPS = 2 * 3500 = 7000
```

### Media Storage:
#### Tweet Size Breakdown:
- Tweet ID: 64 bytes
- Text content: 140 bytes (140-character limit for tweets)
- Media (if present): 1 MB (Assumed average media size)

#### Media Storage Calculation:
```
Media tweets per day = 10% * 300 million = 30 million
Each media file is 1 MB
Media storage per day = 1 MB * 30 million = 30 TB per day
Media storage for 5 years = 365 * 30 TB * 5 = 54750 TB = 55 PB (approx.)
```

## Commonly asked back-of-the-envelope estimations:
- QPS
- Peak QPS
- Storage
- Cache
- Number of servers, etc.
