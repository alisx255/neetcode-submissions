class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for i in range(len(s)):
            if s[i] == '{' or s[i] == '(' or s[i] == '[':
                stack.append(s[i])
            else:
                if len(stack) == 0:
                    return False
                c = stack.pop()
                if c == '(':
                    if s[i] != ')':
                        return False
                if c == '{':
                    if s[i] != '}':
                        return False
                if c == '[':
                    if s[i] != ']':
                        return False
        if len(stack) == 0:
            return True
        return False
        