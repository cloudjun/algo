Assuming that the building is k stories high, and we have n xboxes to test with.

If we drop the xbox at x-th story (1<=x<=k), there are two possible scenarios:
1) the xbox is broken. This means we have n-1 xboxes left, and the lowest story is between 1 and x, which means there is x-1 stories to test.
2) the xbox is not broken. This means we still have n xboxes left, and the lowest story is between x+1 and km, which means there is k-x stories to test.
Let's define dropXbox(n,k) as the number you have to test in the worst case scenario when you have n xboxes and k stories. At x story, where you drop the xbox for the first time, your worst case scenario is max(dropXbox(n-1,x-1),dropXbox(n,k-x)). In order to get the smallest number of tests in all the worst cases, you have to try everyone of the stories, so dropXbox(n,k)=min(max(dropXbox(n-1,x-1),dropXbox(n,k-x)))+1:x in {1,2,...,k}. We need to add one because we already tested one time at that story.
