n = int(input())
a = input().split()

for i in range(n):
    a[i] = int(a[i])

result = []

for i in range(23):
    result.append(0)

for i in range(n):
    result[a[i]-1]+=1
for i in range(23):
    print(result[i], end=' ')
