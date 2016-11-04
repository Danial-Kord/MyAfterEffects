# Benchmark for MyAfterEffects #

### Benchmark with I5-3570K

* CPU : i5-3570K 3.40 Ghz 4 cores
* RAM : 12Go 1333MHz DDR3
* Disk : 128Go Samsung SSD 840 Series

| Thread count |  1 video with no filter | 1 video with Border Detection |  2 videos with 1 Transparency | 3 videos with 1 LowPass, 1 Sharpen, 2 transparency |
| ------------- | ------------- | --------- | --------- | --------- |
| 1 |        103        |      554| 193| 1265|
| 2 |        100        |      312| 125| 675 |
| 4 |        101        |      230| 116| 433 |
| 8 |        101        |      223| 114| 430 |
| 16 |        103       |      228| 113| 428 |
| 32|        105        |      226| 114| 428 |

![](graphs/benchmark_i5-3570K.png)

### Benchmark with i7-3770K

* CPU : i7 3770K 3.50GHz 4 Cores (8 threads)
* RAM : 16384 MB RAM (4 * 4096 MB Crucial Balistix Sport 1600MHz) DDR3
* Disk : 2 TB Seagate Drive (7200 RPM)

| Thread count |  1 video with no filter | 1 video with Border Detection |  2 videos with 1 Transparency | 3 videos with 1 LowPass, 1 Sharpen, 2 transparency |
| ------------- | ------------- | --------- | --------- | --------- |
| 1 |        71|      644| 272| 1640|
| 2 |        77|      429| 214| 1077|
| 4 |        85|      339| 166| 930|
| 8 |        94|      361| 195| 955|
| 16 |        100|      288| 202| 930|
| 32|        100|      318| 220| 937|

![](graphs/benchmark_i7-3770K.png)

### Benchmark with i7-4700HQ

* CPU : i7 4700HQ 2.4GHz 4 Cores (8 threads)
* RAM : 12288 MB RAM (1 * 8192 MB and 1 * 4096 MB 1600MHz) DDR3
* Disk : 960 GB SanDisk Ultra II SSD

| Thread count |  1 video with no filter | 1 video with Border Detection |  2 videos with 1 Transparency | 3 videos with 1 LowPass, 1 Sharpen, 2 transparency |
| ------------- | ------------- | --------- | --------- | --------- |
| 1 |        95|      556| 250| 1352|
| 2 |        97|      321| 187| 822|
| 4 |        95|      230| 173| 591|
| 8 |        97|      204| 179| 555|
| 16 |        95|      208| 174| 552|
| 32|        96|      209| 181| 544|

![](graphs/benchmark_i7-4700HQ.png)
