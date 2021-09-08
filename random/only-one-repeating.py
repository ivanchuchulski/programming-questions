

def solve_1(arr):
    mapping = {}
    for elem in arr:
        if elem in mapping:
            mapping[elem] += 1
        else:
            mapping[elem] = 1

    for k, v in mapping.items():
        print("number {}, value {}".format(k, v))

        if v == 2:
            print("value {} is repeating".format(v))

# O(N)
def solve(arr):
    repeating = set()

    for elem in arr:
        if elem not in repeating:
            repeating.add(elem)
        else:
            repeating.remove(elem)
            print("repeating is {}".format(elem))
            break
            # eventually break


def solve_brute(arr):
    for i in range(len(arr)):
        for j in range(len(arr)):
            if i == j:
                continue
            
            if arr[i] == arr[j]:
                print("repeating number is {} in indexes {} and {} ".format(arr[i], i , j))
                return



def main():
    arr = [10, 211, 3, 4, 5, 7, 7]
    arr.append(16)
    print(arr)

    # solve(arr)
    solve_brute(arr)

if __name__ == "__main__":
    main()
