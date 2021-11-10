# problem
- find first non-repeated character in a string
# steps
- generate a sample string of 45,000 random unicode characters
- traverse through the string and record needed info
- find the first non-repeated character by the recorded info

# performance
- with 45,000 characters:
  - with primitive array: 
    - repetitive looping to record firsttime and repeated character: 600ms
    - record first time and repeated character directly on codepoint array: 25ms
  - with map: 35ms
  - with map and stream: 65ms