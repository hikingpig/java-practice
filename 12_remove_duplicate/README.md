# problems
- remove duplicate characters in a string
# steps
- check for correctness
- generate sample string
- measure performance
# performance
- With 45,000 characters sample string
  - iterative(quadratic complexity): 95s
  - using LinkedHashSet: 57ms
  - store positions in an array: 19ms
