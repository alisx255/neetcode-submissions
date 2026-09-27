class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        for i in range(len(tokens)):
            c = tokens[i]
            if c == "+":
                a = stack.pop()
                b = stack.pop()
                stack.append(b + a)
            elif c == "-":
                a = stack.pop()
                b = stack.pop()
                stack.append(b - a)
            elif c == "*":
                a = stack.pop()
                b = stack.pop()
                stack.append(b * a)
            elif c == "/":
                a = stack.pop()
                b = stack.pop()

                stack.append(int(b / a))
            else:
                stack.append(int(c))
        return stack.pop()

                    