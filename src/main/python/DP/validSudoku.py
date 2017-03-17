class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        memset = set()
        for i in range(len(board)):
            for j in range(len(board[i])):
                if board[i][j] in memset and board[i][j] != '.': return False
                else: memset.add(board[i][j]) 
            memset.clear()
            for j in range(len(board[i])):
                if board[j][i] in memset and board[j][i] != '.': return False
                else: memset.add(board[j][i]) 
            memset.clear()
        for i in range(3):
            for j in range(3):
                for x in range(3):
                    for y in range(3):
                        val = board[i*3+x][j*3+y] 
                        if val in memset and val != ".": return False
                        else: memset.add(val)
                memset.clear()
        return True


                
        