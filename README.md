# Concurrency

Inspired by few books, explaining in-depth Java multithreading, this repo is a set of practical snippets on the majority of Java concurrency:


1. Basic Thread management (/thread)
    - Runnable
    - create / run thread
    - interrupting thread
    - daemon threads
    - thread groups
    - using ThreadLocal
2. Thread Synchronization (/threadSynchronization)
   - synchronizing methods
   - using Lock
   - data access with Locks (ReadWriteLock)
   - lock fairness
3. Thread Synchronization Utils (/threadSyncUtils)
   - concurrent acces to resource
   - synchronizers (Semaphores, CountDownLatch, CyclicBarrier, Phaser, Exchanger)
4. Thread Executors (/threadExecutors)
   - create thread executors of various type 
   - Callable, and Future 
   - run multiple tasks, processing results 
   - scheduled and periodic task 
   - cancelling task
   - RejectedExecutionHandler
5. Fork/Join Framework(/forkJoin)
   - Fork /Join pool
   - joining results
   - run tasks asynchronously
   - throw Exception in task
   - cancel task
6. Concurrent Collections(/concurrentCollections)
   - Blocking & unblocking collections
   - PriorityBlockingQueue
   - DelayedQueue
   - Thread-safe maps
   - ThreadLocalRandom
   - Atomic variables
   - Atomic arrays
7. Miscellaneous