import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
class Neuron
{
	int[] inputs;
	int threshold;
	int[] next;
	int output;
	public Neuron(int[] inputs, int threshold, int[] next)
	{
		this.inputs = inputs;
		this.threshold = threshold;
		this.next = next;
		output = -1;
	}

}

class Layer
{
	int layerNo;
	Neuron[] neurons;
	public Layer(int layerNo, Neuron[] neurons)
	{
		this.layerNo = layerNo;
		this.neurons = neurons;
	}

	@Override
	public String toString()
	{
		String s = "";
		s+= "Layer no. "+layerNo+"\n";
		for(int i=0;i<neurons.length;i++)
		{
			s+=neurons[i].threshold+"\n";
		}
		return s;
	}
	
}

class McCullochPitts
{
	public static void main(String[] args) throws IOException
	{
		Layer[] layers;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter no. of layers");
		layers = new Layer[Integer.parseInt(br.readLine())];
		for(int i=0;i<layers.length;i++)
		{
			System.out.println("Enter no. of neurons for layer "+i+" ");
			layers[i] = new Layer(i, new Neuron[Integer.parseInt(br.readLine())]);
		}
		
		for(int i=0; i<layers.length;i++)
		{

			for(int j=0;j<layers[i].neurons.length;j++)
			{
				int thresh;
				int[] nexts;
				int[] ips;
				System.out.println("Enter threshold for neuron "+j+" of layer "+i+" ");
				thresh = Integer.parseInt(br.readLine());
				System.out.println("Enter no. of inputs for neuron "+j+" of layer "+i+" ");
				ips = new int[Integer.parseInt(br.readLine())];		
				for(int k=0;k<ips.length;k++)
				{
					System.out.println("Enter input "+k+" for neuron "+j+" of layer "+i+" ");
					ips[k] = Integer.parseInt(br.readLine());
				}
				
				System.out.println("Enter no. of outgoing paths for neuron "+j+" of layer "+i+" ");
				nexts = new int[Integer.parseInt(br.readLine())];
				for(int k=0;k<nexts.length;k++)
				{
					System.out.println("Enter outgoing path "+k+" for neuron "+j+" of layer "+i+" ");
					nexts[k] = Integer.parseInt(br.readLine());
				}
				layers[i].neurons[j] = new Neuron(ips,thresh,nexts);
			}
			
		}
		for(int i=0;i<layers.length;i++)
		{
			System.out.println(layers[i].toString());
		}


		//Code for runtime begins
		//Code for computation of outputs for layer 0
		
		for(int i=0;i<layers[0].neurons.length;i++)
		{
			int weight;
			int sum = 0;
			for(int j=0;j<layers[0].neurons[i].inputs.length;j++)
			{
				System.out.println("Enter weight for input "+j+" of neuron "+i+" of layer 0 ");
				weight = Integer.parseInt(br.readLine());
				sum+= weight*layers[0].neurons[i].inputs[j];
			}
			if(sum>layers[0].neurons[i].threshold)
			{
				layers[0].neurons[i].output = 1;
			}
			else 
				layers[0].neurons[i].output = 0;
		
		}		

		//Code for recomputation of outputs
		for(int i=1;i<layers.length;i++)//Code for layer traversal
		{
			for(int j=0;j<layers[i].neurons.length;j++)//Code for neuron traversal in a layer
			{
				List<Integer> inputs = new ArrayList<Integer>();
				for(int k=0;k<layers[i-1].neurons.length;k++)
				{
					
				}
			}
			
		}

	}
}

