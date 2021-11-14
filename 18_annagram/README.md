# problems
- check if 2 strings are anagram
# steps
- generate samples
- measure performance
# performance
- With 100,000 characters String
  - Arrays.sort : 41ms
  - count occurrences of codepoints: 32ms
  - streams and sorted method: 67ms
