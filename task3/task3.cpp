#include <stdlib.h>
#include <crtdbg.h>
#include <iostream>
#include <iomanip>
#include <fstream>
#include <string>
#include <cstdlib>
#include <cmath>

using namespace std;

double	*init_n_zero(double *n)
{
	for (size_t i = 0; i != 16; ++i)
		n[i] = 0;
	return (n);
}

size_t	find_max(double *n)
{
	size_t j;
	double	max;

	max = n[0];
	j = 0;
	for (size_t i = 1; i != 16; ++i)
	{
		if (max < n[i])
		{
			max = n[i];
			j = i;
		}
	}
	return (j);
}

int		main(int argc, char **argv)
{
	double	*n;
	size_t	size;
	size_t	i;
	string	line;

	n = new double[16];
	n = init_n_zero(n);
	size = 0;
	i = 1;
	if (argc == 6)
	{
		while (i != 6)
		{
			ifstream in(argv[i]);
			if (in.is_open())
			{
				size = 0;
				while (getline(in, line))
				{
					n[size++] += stod(line);
				}
			}
			in.close();
			i++;
		}
		cout << find_max(n) + 1 << endl;
	}
	delete [] n;
	n = 0;
	return (0);
}
