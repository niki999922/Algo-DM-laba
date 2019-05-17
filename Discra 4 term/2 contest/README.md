# Short guide

You can use a realized turing machine to test your solution on an n-belt machine (including on a single-tape machine).
#### Default setting:
 - Delay 1000 ms
 - Input file - "input.txt"
 - MT file - "MT.txt"
 - Step by step solution without saving previous steps.
 - Start - "S"
 - Accept - "AC"
 - Reject - "RJ"
 - Blank - "_"

#### Example of using:
```
MT <path_input> <path_MT> <delay(ms)> <0/1 (print step by step)> <0/1 (clear steps)>
```

#### Example of input:
```
0000000
```

#### Example of MT:
```
1
S _ -> AC _ ^
S 0 -> N _ >
N 0 -> S _ >
N _ -> RJ _ >
```

## P.S.
##### You can change the source and build it with your changes
