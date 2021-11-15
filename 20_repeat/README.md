# problems
- repean a String n times to create new String
# steps
- measure performance
# performance
- With "hello" and n = 20,000
  - stream generate and collectors.joining: 8ms
  - StringBuilder: 2ms
  - Ncopies and String.join: 28ms
  - char[] and String.replaceAll: 41ms
  - String.format and replaceAll: 16ms
  - String.repeat: 0.1ms!
    - use System.arrayCopy in implementation
