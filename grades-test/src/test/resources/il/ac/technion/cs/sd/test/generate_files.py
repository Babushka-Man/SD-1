import random

# Function to generate a single file with the specified constraints
def generate_file(filename, num_lines):
    with open(filename, 'w') as file:
        for _ in range(num_lines):
            first_number = random.randint(1, 999_999_999)  # Up to 9 digits
            second_number = random.randint(1, 999)        # Up to 3 digits
            file.write(f"{first_number},{second_number}\n")

# Generate 5 files with line counts between 900,000 and 1,000,000
line_counts = [random.randint(900_000, 1_000_000) for _ in range(5)]
filenames = [f"numbers_file_{i+1}.txt" for i in range(5)]

# Create the files
for filename, num_lines in zip(filenames, line_counts):
    generate_file(filename, num_lines)

filenames  # Return the file names and line counts for confirmation
