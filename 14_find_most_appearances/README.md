# problems
- find a character that has most appearances in a string
# steps
- check for correctness
- generate sample string
- measure performance
# performance
- With 200,000 characters sample string
  - store codepoint counts in an array: 12ms
  - hashmap: 90ms (a lot of auto-boxing and unboxing)
  - stream: 100ms
