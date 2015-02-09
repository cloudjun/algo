using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace algo
{
    class Subsets
    {
        readonly int[] _input = { 1, 2, 3, 4 };

        public Subsets()
        {
            var result = new List<List<int>>();
            var tempResult = new List<int>();

            DoRecursiveWork(result, tempResult, 0);
            var sb = new StringBuilder();
            result.ForEach(list =>
            {
                if (list.Count == 0)
                {
                    sb.Append("[]\n");
                }
                else
                {
                    sb.Append("[");
                    list.ForEach(v => sb.Append(v + ","));
                    sb.Remove(sb.Length - 1, 1);
                    sb.Append("]\n");
                }
            });
            Console.WriteLine(sb);
        }

        private void DoRecursiveWork(ICollection<List<int>> res, List<int> tempRes, int pos)
        {
            res.Add(new List<int>(tempRes));

            for (int i = pos; i < _input.Length; i++)
            {
                tempRes.Add(_input[i]);
                DoRecursiveWork(res, tempRes, i + 1);
                tempRes.Remove(_input[i]);
            }
        }
    }

}
