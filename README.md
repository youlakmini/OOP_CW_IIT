# OOP_CW_IIT
# Real-Time Event Ticketing System
Real-time analytics on page views for a multi-threaded event ticketing system based on web-sockets, a producer-consumer queue and more.
## Project Description
Real-Time Event Ticketing System Virtualization — It is a process of multiple vendors and customers release and purchase tickets. By utilizing multi-threading and synchronization methods, it ensures that the system functions effectively even in scenarios involving high concurrency.
## Features
- Multi-threaded ticket releases by vendors
- Multi-threaded ticket purchases by customers
- Thread-safe ticket pool management
- Real-time ticket availability updates
- Simple yet effective UI with configuration options
## Technology Stack
- **Frontend**: React.js 
- **Backend**: Java (Spring Boot)
- **Concurrency**: Java Threads, Synchronization

## Usage Instructions
After setting up the project, follow these steps to interact with the ticketing system:

1. **Configuration**:
   - Input the total number of tickets available.
   - Set the ticket release rate for vendors and the retrieval rate for customers.
   - Define the maximum ticket capacity.

2. **Starting the system**:
   - Click **Start** to begin ticket release and purchase processes.
   - The status will update in real-time as vendors release tickets and customers make purchases.

.

3. **Stopping the system**:
   - Click **Stop** to halt the processes.
