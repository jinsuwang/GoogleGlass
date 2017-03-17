import unittest

class TestMazeSolver(unittest.TestCase):

    def setUp(self):
        grid = [
            [0, 0, 0, 0, 0, 1],
            [1, 1, 0, 0, 0, 1],
            [0, 0, 0, 1, 0, 0],
            [0, 1, 1, 0, 0, 1],
            [0, 1, 0, 0, 1, 0],
            [0, 1, 0, 0, 0, 2]
        ]
        # grid = [[0,0],[0,2]]
        self.ms = MazeSolver( grid )
    

    def test_solve(self):
        print self.ms.solve(0,0)
        print self.ms.path
        self.assertTrue(self.ms.solve(0,0))
