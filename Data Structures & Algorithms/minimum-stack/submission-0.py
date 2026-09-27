class MinStack:

    def __init__(self):
        self.stack = []
        self.minStack = []
        self.n = 0

    def push(self, val: int) -> None:
        self.stack.append(val)
        if len(self.minStack) == 0:
            self.minStack.append(val)
        else:
            if val < self.minStack[self.n - 1]:
                self.minStack.append(val)
            else:
                self.minStack.append(self.minStack[self.n - 1])
        self.n = self.n + 1

    def pop(self) -> None:
        self.stack.pop()
        self.minStack.pop()
        self.n = self.n - 1
        

    def top(self) -> int:
        return self.stack[self.n - 1]
        

    def getMin(self) -> int:
        return self.minStack[self.n - 1]
        
