# problems
- Reverse all letters in each word of a string
# steps
- generate sample string in unicode
- test the code
# performance
- With 100,000 words
  - iterative version: 100ms
    - avoid creating a string builder for each word
  - stream version: 135ms
    - Collectors seems more efficient at joining the string
