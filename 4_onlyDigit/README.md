# problems
- Check if a string contains only digits
# steps
- generate sample string contains digits and (maybe) text
- measure performace for each solution
# performance
- With 100,000 digits
  - regex: 12ms
  - iterative: 10ms
  - streams: 19ms
- With 50,000 digts + text + 50,000 digits
  - regex: 4ms
  - iterative: 2ms
  - streams: 15ms (after the first stream text run, the 2nd may be very fast, must run them separately)