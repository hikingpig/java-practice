# problems
- count the how many times a character appears in a string
# steps
- generate sample string and a random character
- measure performace for each solution
# performance
- With 300,000 ascii Unicode characters
  - string replacement: 15ms
  - iteration: 11ms
  - streams: 23ms
- If run repetitively, VM optimization make it less than 1ms for all the above
