# problems
- count the number of consonants and vowels in a string
# steps
- generate sample string contains only ascii
- measure performace for each solution
# performance
- With 100,000 ascii characters
  - iterative: 12ms
  - streams: 14ms
    - the second run of streams are mostly significantly faster (may reach 4ms)
