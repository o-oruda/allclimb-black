# user-api

## package structure 

```
io.ooruda.allclimb.user
├─ domain
│  ├─ tickets
|  |  ├─ my 
|  |  └─ pay 
│  ├─ gyms 
│  └─ my
└─ global
   ├─ common  
   ├─ config
   └─ util
```

- tickets : 이용권  기본 
  - my : 구매 이용권, 이용권 사용, 내 이용권(활성화)
  - pay : 이용권 구매
- gyms : 암장 조회(지역별 암장, 암장 상세 정보, 인기랭크 .. )
- my : 기록 … (나중에) 