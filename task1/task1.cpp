#include <stdlib.h>
#include <crtdbg.h>
#include <iostream>
#include <iomanip>
#include <fstream>
#include <string>
#include <cstdlib>
#include <cmath>

using namespace std;

void	swap(short *a, short *b)
{
	int	tmp;

	tmp = *a;
	*a = *b;
	*b = tmp;
}

double	avg(short *n, unsigned size)
{
	double	a;
	size_t	i;

	a = 0;
	i = 0;
	while (i != size)
		a += n[i++];
	return (a /= i);
}

short	*buble_sort(short *n, unsigned size)
{
	size_t j;

	j = 0;
	for (size_t i = 0; i != size; ++i)
	{
		j = i + 1;
		for (; j != size; ++j)
		{
			if (n[i] >= n[j])
				swap(&n[i], &n[j]);
		}
	}
	return (n);
}

double	percentil09(short *n, unsigned size)
{
	double	p;
	int		i;

	i = 0;
	p = 0.9 * (size - 1);
	i = trunc(p);
	return (n[i] + (p - i) * (n[i + 1] - n[i]));
}

double	mediana(short *n, unsigned size)
{
	if (size % 2 == 0)
		return ((n[size / 2] + n[size / 2 - 1]) / 2);
	else
		return (n[size / 2]);
}

short	*resize(short *n, unsigned size, unsigned new_size)
{
	short *n1;

	n1 = new short[new_size];
	for (size_t i = 0; i != new_size; ++i)
		n1[i] = n[i];
	delete [] n;
	n = 0;
	return (n1);
}

int		main(int argc, char **argv)
{
	short	*n;
	size_t	size;
	string	line;

	cout << setprecision(2) << fixed;
	n = new short[1000];
	size = 0;
	if (argc == 2)
	{
		ifstream in(argv[1]);
		if (in.is_open())
		{
			while (getline(in, line))
				n[size++] = stoi(line);
		}
		else
		{
			cout << "Wrong argument" << endl;
			return (0);
		}
		in.close();
		n = resize(n, 1000, size);
		n = buble_sort(n, size);
		cout << percentil09(n, size) << endl;
		cout << mediana(n, size) << endl;
		cout << (double)n[size - 1] << endl << (double)n[0] << endl;
		cout << avg(n, size) << endl;
	}
	else
		cout << "Wrong quantity of arguments" << endl;
	delete [] n;
	n = 0;
	return (0);
}
