n = int(input())
a = input().split()

for i in range(n):
    a[i] = int(a[i])

min = 99999
for i in range(n):
    if min>a[i]:
        min=a[i]
print(min)
