When we have 2 xboxes and 120 stories, to get the minimum number of tries, there must exist a lowest level where we do the first drop test, from which if the xbox breaks, we have to go down to the first floor and test every floor up, and if the xbox does not break, we will go up one level less then the current floor's number and continue with our tests. So assume the lowest floor where we start the dropping test is n, it is something like this:
>n + (n-1) + (n-2) + (n-3) + (n-4) + … + 1  >=  120

So **n is 15**.

There is also a programmable way to solve this problem. Assuming that the building is k stories high, and we have n xboxes to test with.

If we drop the xbox at x-th story (1<=x<=k), there are two possible scenarios:
>1) the xbox is broken. This means we have n-1 xboxes left, and the lowest story is between 1 and x, which means there is x-1 stories to test.
>2) the xbox is not broken. This means we still have n xboxes left, and the lowest story is between x+1 and km, which means there is k-x stories to test.

Let's define dropXbox(n,k) as the number you have to test in the worst case scenario when you have n xboxes and k stories. At x story, where you drop the xbox for the first time, your worst case scenario is max(dropXbox(n-1,x-1),dropXbox(n,k-x)). In order to get the smallest number of tests in all the worst cases, you have to try everyone of the stories, so dropXbox(n,k)=min(max(dropXbox(n-1,x-1),dropXbox(n,k-x)))+1:x in {1,2,...,k}. We need to add one because we already tested one time at that story. Please refer to the code to see how it is done.

This problem can also be solved by Dynamic Programming. Due to time constraints, here is only the recursion solution for it.