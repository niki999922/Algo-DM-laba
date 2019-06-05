import System.IO

main = do
    a < -getLine
    b < -getLine
    putStr $ show $(read a::Integer) * (read b::Integer)