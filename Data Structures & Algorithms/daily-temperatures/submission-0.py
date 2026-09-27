class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = []
        result = [0] * len(temperatures)
        for i in range(len(temperatures)):
            t = temperatures[i]
            if not stack:
                stack.append((t, i))

            elif t > stack[-1][0]:
                while stack and t > stack[-1][0]:
                    index = stack[-1][1]
                    diff = i - index
                    result[index] = diff
                    stack.pop()

            stack.append((t, i))
        return result